<template>
        <div class="footer">
    <router-link to="/"> Home </router-link>
   <router-link to="/contact">Contact</router-link>
        </div>
        
</template>


<style>
.footer {
  overflow: hidden;
  background-color: #333;
  position: fixed;
  bottom: 0%;
  width: 100%;

}
.footer a{
  float: left;
  display: flexbox;
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
  padding: 13px;
  margin-bottom: 10px;
}
</style>