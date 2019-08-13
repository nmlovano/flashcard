<template>
    <div>
        <h1>Here's some decks!</h1>
            <ul id="decks">
                <li v-for="item in decks" v-bind:key="item.id"/>
            </ul>
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
        .then((decks) => {
          this.decks = decks;
        });
            }
            
    	    
	    } 
    }
</script>

<style>

</style>