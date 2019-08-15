<template>
    <div>
        <h1>Here's your cards</h1>
            <ul id="cardsByDeck">
                <li v-for="item in card" v-bind:key="item.id">
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
        getCardByDeckOrdered(){
            fetch(this.API_URL + '/deckOrder={deckId}', {
                headers: {
                    Authorization: 'Bearer ' + auth.getToken()
                }
            })
            .then((response) => {
                return response.json();
            })
            .then((card) => {
                console.log (card);
                this.card = card;
            });
        }   
    },
    created() {
        const card = {
            template: '<div>card {{ $route.params.deckId }}</div>'
        }
        this.getCardByDeckOrdered();
    }
    
}
</script>

<style>

</style>