<template>
<div class="photo">
  <div class="admin">
    <h1>Heyyyyyy</h1>
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

