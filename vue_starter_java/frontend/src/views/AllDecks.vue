<template>
    <div class="allDecks">
        <h1>Here's some decks!</h1>
            <ul id="deck">
                <li v-for="item in deck" v-bind:key="item.id">
                <img id="red-black-card" src= "../Images/card-deck.png"/>
               <div id="card-name"> {{item.name}} </div>
               <div id="card-desc">{{item.description}}</div>
               <div id="card-link"> <router-link v-bind:to="'/cardsByDeck/' + item.deckId">View Cards </router-link></div>
               <div id="card-link"> <router-link v-bind:to="'/cardsByDeckShuffled/' + item.deckId">View Cards Shuffled </router-link></div>
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
            })
            const card = {
                template: '<div>card {{ $route.params.deckId }}</div>'
            };
        }   
    },
    created() {
        this.getAllDecks();
    }
}
</script>

<style>
#deck{
    list-style: none;
    display:flex;
    
}
#card-name{
    font-weight:bold;
    font-size: 40px;
    text-align: center;
    position: relative;
}
#card-desc{
    font-style:italic;
    font-size: 25px;
    text-align: center;
    position: relative;
}
#card-link{
    font-size:20px; 
    text-align:center;

}
</style>