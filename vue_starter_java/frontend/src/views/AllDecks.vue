<template>
    <div>
        <h1>Here's some decks!</h1>
            <ul id="deck">
                <li v-for="item in deck" v-bind:key="item.id"/>
                {{item.name}}
            </ul>
    </div>
</template>

<script>
    export default {
        data() {
            return { 
                API_URL: '',
                deck: []
            }
        },
        methods: {
            getAllDecks(){
                fetch(this.API_URL)
                .then((response) => {
                    return response.json();
                })
                .then((deck) => {
                    this.deck = deck;
                });
            }   
	    } 
    }
</script>

<style>

</style>