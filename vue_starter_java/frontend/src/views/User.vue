<template>
	<div class="user">
		<router-link to="user"></router-link>
		<h1 id="welcome-msg"> Welcome{{user.firstname}}! </h1>
		<p id="learn">Let's start learning!</p>
		<table>
			<tr>User Name: <div id="info">{{user.username}}</div></tr>
			<tr>Email: <div id="info">{{user.email}}</div></tr>
			<tr> First Name: <div id="info">{{user.firstName}}</div></tr>
			<tr> Last Name: <div id="info">{{user.lastName}}</div></tr>
		</table>

		<div class="deckButton">
			<router-link to="/allDecks" tag="button">View Decks!</router-link>
		</div>
		<div class="admin-button">
			<router-link v-show="isAdmin()==true" to="/admin" tag="button">Take me to the Admin Page!</router-link>
		</div>
	</div>
</template>

<script>
  import VueRouter from 'vue-router'
  import Vue from 'vue'
   import auth from '../auth'
   import admin from './Admin'
  

  export default {
	name: 'user',
	components: {
	},
	data() {
		return {
			API_URL: process.env.VUE_APP_REMOTE_API,
			filterValue: '',
			user: {
				username:'',
				email:'',
				firstName:'',
				lastName:'',
				role:''
			},
		}
	},
	methods: {
		getUserDetails(){
			fetch(this.API_URL + '/user',{
			method: 'GET',
			headers: {
				Accept: 'application/json',
				Authorization: 'Bearer '+ auth.getToken()
			},
			})
			.then((response) => {				//this is not the data... it is an obj that contains data and transmission information
			return response.json(); 
			})
			.then((user)=>{	
				this.user.username=user.username;
				this.user.email=user.email;
				this.user.firstName=user.firstName; 
				this.user.lastName=user.lastName; 
				this.user.role=user.role; 		//  variable we are setting = variable we got back to the response 
				
			}
			)},
			isAdmin(){
				if(this.user.role == "admin"){
					return true;
				}
				else {
					return false;
				}
			}
		},
		created(){
			this.getUserDetails(); 
			this.isAdmin(); 
		},

	}

</script>

<style>
tr {
	font-weight: bold; 
	font-size: 30px;
	text-emphasis-color: blue; 
}
.user{
	padding:80px; 
	background-color:lightcyan;
}

#welcome-msg{
	font-size: 50px;
}
#learn{
	font-size: 30px;
	font-style: italic;
}
#info{
	font-weight:lighter;

}
</style>

