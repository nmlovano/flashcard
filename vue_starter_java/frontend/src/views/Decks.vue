<template>
  <div class="deck-id">
    <form action="/Card">
      <button type="redirect">Add a Card!</button>
    </form>
    <form action="/deck">
      <button type="redirect">Make a new Deck!</button>
    </form>
     <pre>{{deck}}</pre>
     <div>
        <label for="input-text" class="sr-only">Enter title:</label>
        <input type="text" id="input-text" class="input-text" placeholder="Enter title:" v-model="deck.deckId"/>
     </div>
     <div>
        <label for="input-text" class="sr-only">Enter description:</label>
        <input type="text" id="input-text" class="input-text" placeholder="Enter description:" v-model="deck.description"/>
     </div>
     <table>
       <thead>
         <tr>
           <th>Id</th>
           <th>Front Text</th>
           <th>Back Text</th>
           <th>Tags</th>
         </tr>
       </thead>
       <tbody>
          <tr v-for="card in cards" v-bind:key="card.cardId">
            <td>{{card.cardId}}</td>
            <td>{{card.frontText}}</td>
            <td>{{card.backText}}</td>
            <td>{{card.tags}}</td>
          </tr>
       </tbody>
     </table>
     <form action="/Admin">
      <div>
          <button type="submit">Save Changes to this Deck</button>
      </div>
     </form>
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
      fetch(`${process.env.VUE_APP_REMOTE_API}/Register`, {
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