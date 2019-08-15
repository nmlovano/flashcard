<template>
    <div>
        <h1>Here's your cards shuffled</h1>
            <ul id="cardsByDeckShuffled">
                <li v-for="item in card" v-bind:key="item.id">
                {{item.frontText}} - {{item.backText}} - {{item.cardTag}}
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
            card: null
        }
    },
    methods: {
        getCardByDeckShuffled(){
            const deckId = this.$route.params.deckId;
            fetch(this.API_URL + '/shuffled/' + deckId, {
                headers: {
                    Authorization: 'Bearer ' + auth.getToken()
                }
            })
            .then((response) => {
                console.log(response);
                return response.json();
            })
            .then((card) => {
                console.log (card);
                this.card = card;
            }); 
        }
    },
    created() {
        this.getCardByDeckShuffled();
    }
    
}
</script>

<style>

</style>