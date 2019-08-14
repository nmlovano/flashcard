<template>
	<div class="user">
		<router-link to="user"></router-link>
		<h1>Welcome!</h1>
		<p>Welcome to this page!</p>
		<!-- <table>
			<v-for="piece in user" v:bind:key="piece.username">
			<tr>User Name: {{piece.username}}</tr>
			<tr>Email: {{piece.email}}</tr>
			<tr> First Name: </tr>
			<tr> Last Name: </tr>
		</table> -->
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
			filterValue: ''
		}
	},
	methods: {
		},
		created(){
			this.getUserDetails(); 
		},
		getUserDetails(username){
			fetch(this.API_URL + '/user/username={{username}}',{
			method: 'GET',
			headers: {
				Accept: 'application/json',
				'Content-Type': 'application/json',
				Authorization: 'Bearer: '+ auth.getToken()
			},
			body: JSON.stringify(this.user),
			})
			.then((response) => {
			if (response.ok) {
				return user;
			}
			})
		}
	}

</script>

<style>

