<template>
  <div id="login" class="text-center">
    <router-link to="/Login"></router-link>
    <form class="form-signin" @submit.prevent="login">
      <div class="header">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      </div>
      
      <div class="alert alert-success" role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <div class="button">
  
      <button type="submit">Sign in</button></div>
    </form>
    <div class="account">
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      </div>
  </div>

</template>

<script>
import auth from '../auth';


export default {
  name: 'login',
  components: {},
  data() {
    return {
      user: {
        username: '',
        password: '',
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/Login`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((token) => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
            this.$router.push('/');
          }
        })
        .catch((err) => console.error(err));
    },
  },
};
</script>

<style>

#login{
  color:black;
  font-family: 'Times New Roman', Times, serif;

}
 
#button{



  padding: 15px 32px;
  text-align: center;
 

  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.header{
  font-family: Arial, Helvetica, sans-serif;
  text-align:center
}
.account{
  font-size: 16px;
   text-align: center;
}
</style>