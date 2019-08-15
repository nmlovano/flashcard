<template>
	<div class="user">
		<router-link to="user"></router-link>
		<h1>Welcome!</h1>
		<p>Welcome to this page!</p>
		<table>
			<tr>User Name: {{user.username}}</tr>
			<tr>Email: {{user.email}}</tr>
			<tr> First Name: {{user.firstName}}</tr>
			<tr> Last Name: {{user.lastName}}</tr>
		</table>
		<div class="deckButton">
			<router-link to="/decks" tag="button">View Decks!</router-link>
		</div>
	</div>
</template>

<script>
  import VueRouter from 'vue-router'
  import Vue from 'vue'
   import auth from '../auth'
  

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
				lastName:''
			}
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
				this.user.lastName=user.lastName; //  variable we are setting = variable we got back to the response 
			}
			)
		}
		},
		created(){
			this.getUserDetails(); 
		},

	}

</script>

<style>

