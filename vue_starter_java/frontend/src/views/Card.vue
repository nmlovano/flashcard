<template>
    <div class="card">
        <h1>Card</h1>
        <div>
            <label for="fronttext" class="fronttext">Front Text</label>
            <input type="text" id="input-text" class="input-text" placeholder="Enter front text here!" v-model="frontText"/>
        </div>
        <div>
            <label for="backtext" class="backtext">Back Text</label>
            <input type="text" id="input-text" class="input-text" placeholder="Enter back text here!" v-model="backText"/>
        </div>
        <div>
            <button v-on:click="saveCard">Save Card to Deck!</button>
            <button>Discard dis card!</button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'card',
    data(){
        return {
            id: "",
            frontText: "",
            backText: ""
        }
    },
    methods: {
      saveCard(){
        fetch(`${process.env.VUE_APP_REMOTE_API}/Login`, {
          method: 'POST',
          headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(this.user),
        })
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((token) => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
            this.$router.push('/');
          }
        })
        .catch((err) => console.error(err));
      }
    }
}
</script>

<style>

</style>