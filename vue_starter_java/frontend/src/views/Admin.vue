<template>
<div class="photo">
  <div class="admin">
    <h1>Welcome to your deck page</h1>
    <a href="/deck">
        <button type="redirect">Add/Edit Decks Here!</button>
    </a>
  </div>
  <table>
    <thead>
      <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Cards</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="deck in decks" v-bind:key="deck.id">
        <td>{{deck.id}}</td>
        <td>{{deck.title}}</td>
        <td>{{deck.cards}}</td>
      </tr>
    </tbody>
  </table>
</div>
</template>

<script>
import auth from "../auth"
export default { 
  name: 'adminsdecks',
  data(){
    return{
      user: null,
      decks: [
        {
          id: 1,
          title: "First Deck.",
          cards: 10
        },
        {
          id: 1,
          title: "Second Deck.",
          cards: 20
        },
      ]
    }
  },
  methods: {
    getDecksByUserId(){
        fetch(`${process.env.VUE_APP_REMOTE_API}/deck?userId={userId}`,{
          method: 'GET',
          headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(this.card),
        })
        .then((response) => {
          if (response.ok) {
            return deckId;
          }
        })
    }

  },
  created(){
    this.getDeck(this.$route.params.id);
  }
}
</script>

<style>

.admin{
  background-color: aliceblue;
  text-align: center;

}

</style>

