<template>
    <div class="deck">
        <h1>Deck</h1>
        <div>
            <label for="fronttext" class="fronttext">Deck Name</label>
            <input type="text" id="input-text" class="input-text" placeholder="Enter front text here!" v-model="frontText"/>
        </div>
        <div>
            <label for="backtext" class="backtext">Deck Description</label>
            <input type="text" id="input-text" class="input-text" placeholder="Enter back text here!" v-model="backText"/>
        </div>
        <div>
            <button v-on:click="saveDeck">Save Deck!</button>
            <button>Discard Deck!</button>
        </div>

        <div>
          <router-link to="/card" tag="button">Add Cards</router-link>
        </div>
    </div>

    
</template>   


<script>
export default {
  name: 'cards',
  data() {
    return {
      cards: {
        cardId: '',
        frontText: '',
        backText: '',
        tags: ''
      }
    }
  },
  methods: {
    displayCards(){
      fetch(`${process.env.VUE_APP_REMOTE_API}/deck?userId={userId}`, {
        method: 'GET',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
      })
      .then((response) => {
          if (response.ok) {
            this.$router.push({ path: '/deck', query: { cards: 'success' } });
          }
        })
      .then((err) => console.error(err));
    }
  },
  created() {
    this.getDeck(this.$route.params.id);
  }
}
</script>
<style>
</style>