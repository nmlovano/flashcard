
<template>
<div class="photo">
  <div class="admin">
    <h1 id="deck-page">Welcome to your deck page! </h1>
    <a href="/addDeck">
        <button id="add-decks-here" type="redirect">Add Decks Here!</button>
    </a>
  </div>
  <table>
    <thead>
      <tr>
        <th>Your Current Decks</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="deck in decks" v-bind:key="deck.id">
         <img id="admin-card" src= "../Images/card-deck.png"/>
        <td><router-link to="/deck={deckId}" tag="button">{{deck.name}}</router-link></td>
        <div>
        <tr> Description: <div id="admin-desc">" {{deck.description}} "</div></tr>
        </div>
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
        
      ]
    }
  },
  methods: {
    getDecksByUserId(){
      fetch(`${process.env.VUE_APP_REMOTE_API}/decksByUser`,{
        method: 'GET',
        headers: {
          Accept: 'application/json',
          Authorization: 'Bearer ' + auth.getToken()
        }
      })
      .then((response) => {
        return response.json();
      })
      .then((decks) => {
        this.decks = decks;
      })
    }
  },
  created(){
    this.getDecksByUserId();
  }
}
</script>

<style>
#admin-card{
 width: 70%;
  margin: 20px;
}
#admin-desc{
  font-size:25px;
  font-style:italic;
  font-weight: lighter;
}

#deck-page{
  padding: 80px; 
  font-size: 60px;
}
#add-decks-here{
  width: 200px;
  margin: 20px;
  border-color: red;
  border-width: 5px;
  border-radius:5%;
}
</style>
