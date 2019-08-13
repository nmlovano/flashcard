<template>
    <div>
        <h1>Here's some decks!</h1>
        <div class="decks" v-for="deck in alldecks" v-bind:key="deck.decks">
            {{deck.id}}
        </div>
    </div>
</template>

<script>
    export default {
        name: 'decks',
        data(){
            return {
                decks: {

                }
            }
        },
        methods: {
            getAllDecks(){
                fetch(this.API_URL)
        .then((response) => {
          return response.json();
        })
        .then((groceries) => {
          this.groceries = groceries;
        });
            }
            
    	    
	    } 
    }
</script>

<style>

</style>