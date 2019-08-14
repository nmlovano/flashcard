<template>
    <div>
        <h1>Here's some decks!</h1>
            <ul id="deck">
                <li v-for="item in deck" v-bind:key="item.id">
                {{item}}
                </li>
            </ul>
    </div>
</template>

<script>
import auth from '../auth';

export default {
    data() {
        return { 
            API_URL: process.env.VUE_APP_REMOTE_API,
            deck: null
        }
    },
    methods: {
        getAllDecks(){
            fetch(this.API_URL + '/decks', {
                headers: {
                    Authorization: 'Bearer ' + auth.getToken()
                }
            })
            .then((response) => {
                return response.json();
            })
            .then((deck) => {
                console.log (deck);
                this.deck = deck;
            });
        }   
    },
    created() {
        this.getAllDecks();
    }
}
</script>

<style>

</style>