<template>
<div class="deck-id">
     <pre>{{deck}}</pre>
   </template>    


<script>
import userService from '@/service/UserService';
export default {
  name: 'deck-name',
  data() {
    return {
      user: null,
    }
  },
  methods: {
    getDeck(id) {
      userService.get(id).then(deck => this.deck = deck);
    }
  },
  created() {
    this.getDeck(this.$route.params.id);
  }
}
</script>

