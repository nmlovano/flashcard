<template>
       <div class="footer">
      <a href="/Home">Home</a>
      <a href="/Register">Register</a>
          <a href="/Admin">Admin</a> 
         <a href="/Contact">Contact</a>
         <a href="Login">User Login</a>
        </div>
        
</template>
<script>
export default {
  name: 'app-footer'
}
</script>

<style scoped>
.footer {
  overflow: hidden;
  background-color: #333;
  position: fixed;
  bottom: 0%;
  width: 100%;

}
.footer a{
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.footer a:hover {
  background: #f1f1f1;
  color: black;
}

.footer a.active {
  background-color: #4CAF50;
  color: white;
}

.footer {
  padding: 16px;
  margin-bottom: 30px;
}
</style>