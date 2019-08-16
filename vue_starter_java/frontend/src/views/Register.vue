<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create New Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        There were problems registering this user.
      </div>
      <div id="register-username">
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
      </div>
      <div id="register-passwords">
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="register-password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
       <label for="password" class="sr-only">Confirm Password</label>
      <input
        type="password"
        id="register-confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      </div>
      <div id="names"/>
      <label for="firstname" class="sr-only">First Name</label>
      <input
        type="firstname"
        id="register-firstName"
        class="form-control"
        placeholder="First Name"
        v-model="user.firstName"
        required
      />
      <label for="lastname" class="sr-only">Last Name</label>
      <input
        type="lastname"
        id="register-lastName"
        class="form-control"
        placeholder="Last Name"
        v-model="user.lastName"
        required
      />
    <div id="email"> 
     <label for="email" class="sr-only">Email</label>
      <input
        type="email"
        id="register-email"
        class="form-control"
        placeholder="Enter in Your Email Address"
        v-model="user.email"
        required
      />

      <label for="email" class="sr-only">Confirm Email</label>
       <input
        type="email"
        id="register-confirmEmail"
        class="form-control"
        placeholder="Confirm Email Address"
        v-model="user.confirmEmail"
        required
      />
      </div>
  <div id="switchToLogin">
  
      <router-link :to="{ name: 'Login' }">
        Have an account?
      </router-link>
      </div>
      <div id="button">
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
    };
  },
  methods: {
    register() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/register`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            this.$router.push({ path: '/login', query: { registration: 'success' } });
          } else {
            this.registrationErrors = true;
          }
        })

        .then((err) => console.error(err));
    },
  },
};
</script>

<style>
#register-username{
  display:block; 
  margin-left: auto; 
  margin-right: auto;
  width: 60%; 
  margin: 40px;  
}
#register-password{
  display:block; 
  margin-left: auto; 
  margin-right: auto;
  width: 60%; 
  margin: 40px;  
}
#register-confirmPassword{
  display:block; 
  margin-left: auto; 
  margin-right: auto;
  width: 60%; 
  margin: 40px;
}
#register-firstName{
    display:block; 
  margin-left: auto; 
  margin-right: auto;
  width: 60%; 
  margin: 40px;
}
#register-lastName{
    display:block; 
  margin-left: auto; 
  margin-right: auto;
  width: 60%; 
  margin: 40px;
}
#register-email{
    display:block; 
  margin-left: auto; 
  margin-right: auto;
  width: 60%; 
  margin: 40px;
}
#register-confirmEmail{
    display:block; 
  margin-left: auto; 
  margin-right: auto;
  width: 40%; 
  margin: 30px;
}
</style>
