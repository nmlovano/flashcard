<template>
    <div class="topnav">
      <li><router-link to="/"> Home </router-link></li>
      <li><router-link to="/login">Login</router-link></li>
      <li><router-link to="/user">User Profile</router-link></li>
      <li><router-link v:if="isLoggedIn" to="/logout">Log Out</router-link></li>

       <div class="search-container">
    <form action="/Search">
      <input type="text" placeholder="Search.." name="Search">
      <button type="submit">Submit</button>
    </form>
  </div>
    </div>
</template>
<script>
export default {
  components:{
    name: 'app-header',

  },
methods:{
  isLoggedIn() {
   this.name != null;
  }

}
}
</script>
<style scoped>

</style>