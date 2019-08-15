<template>

    <div class="topnav">
     <router-link to="/"> Home </router-link>
      <router-link to="/login">Login</router-link>
      <router-link to="/user">User Profile</router-link>
       <router-link to="/contact">Contact</router-link>
    <router-link v:if="isLoggedIn" to="/logout">Log Out</router-link>
   
  <form class ="search" action="./searchresults">
   <input type="text" placeholder="Search.." name="search">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>
  </div>

  
    
</template>
<script>
export default {
  components:{
    name: 'AppHeader'

  },
methods:{
  isLoggedIn() {
   this.name != null;
  }

}
}
</script>

<style>
body {
  font-family: Arial;
}

* {
  box-sizing: border-box;
}

form.search input[type=text] {
  padding: 16px;
  font-size: 17px;
  border: 1px solid grey;
  float: right;
  width: 30%;
  background: #f1f1f1;

}
form.search button {
  float: right;
 
  margin-right: 0%;
  padding: 16px;
  background: #FF5D73;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}



.topnav{
overflow: hidden;
  background-color: #333;
  position: fixed;
  
  width: 100%;

}
.topnav a{
  
float: left;
  display: flexbox;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.topnav a:hover {
  background: #f1f1f1;
  color: black;
}

</style>