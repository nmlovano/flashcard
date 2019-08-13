<template>
    <div>
        <h1>Here's some decks!</h1>
        <div class="decks" v-for="deck in alldecks">
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
                fetch(`${this.apiURL}/allDecks={allDecks}`,{
                    method: 'GET',
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify(this.deck),
                })
                .then((response) => {
                    if (response.ok) {
                        const allDecks = this.decks.map(decks => allDecks).indexOf(id)
                        this.decks.splice(allDecks, 1);
                    }
                })
    	    }
	    } 
    }
</script>

<style>

</style>