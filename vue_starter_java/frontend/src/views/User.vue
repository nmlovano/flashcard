<template>
	<div class="user">
		<h1>Welcome!</h1>
		<div>
			<router-link to="/allDecks={allDecks}" tag="button">View Decks!</router-link>
		</div>
	</div>
</template>

<script>
  import VueRouter from 'vue-router'
  import Vue from 'vue'
  

  export default {
	name: 'user',
	
	components: {
	},
	data() {
		return {
			filterValue: ''
		}
	},
	methods: {
		getAllDecks(){
			fetch(`${process.env.VUE_APP_REMOTE_API}/allDecks={allDecks}`,{
			method: 'GET',
			headers: {
				Accept: 'application/json',
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(this.card),
			})
			.then((response) => {
			if (response.ok) {
				return deckId;
			}
			})
    	}
	}
}
</script>

<style>

