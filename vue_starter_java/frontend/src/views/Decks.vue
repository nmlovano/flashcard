<template>
  <div class="deck-id">
     <pre>{{deck}}</pre>
     <h1>Deck Title Goes Here</h1>
     <p>Deck Description Goes Here</p>
     <table>
       <thead>
         <tr>
           <th>Id</th>
           <th>Title</th>
           <th>Description</th>
         </tr>
       </thead>
       <tbody>
          <tr v-for="deck in decks" v-bind:key="deck.id">
            <td>{{deck.id}}</td>
            <td>{{deck.title}}</td>
            <td>{{deck.description}}</td>
          </tr>
       </tbody>
     </table>
  </div>
</template>    


<script>
export default {
  name: 'Decks',
  data() {
    return {
      user: null,
      decks: [
        {
          id: 1,
          title: "First Deck",
          description: "This is a dummy deck"
        },
        {
          id: 2,
          title: "Second Deck",
          description: "This is another dummy deck"
        }
      ]
    }
  },
  methods: {
    getDeck(id) {
      
    }
  },
  created() {
    this.getDeck(this.$route.params.id);
  }
}
<<<<<<< HEAD
=======





  


>>>>>>> 1eea2122866407421036aa101297e32b80e59719
</script>
<style>


</style>