<template>
    <div class="card">
      <form>
        <h1>Card</h1>
        <div>
            <label for="input-text" class="sr-only">Enter text here!</label>
            <input type="text" id="input-text" class="input-text" placeholder="Enter text here!"/>
        </div>
        <div>
            <label for="fronttext" class="fronttext">Front Text</label>
            <button type="submit">Save</button>
        </div>
        <div>
            <label for="backtext" class="backtext">Back Text</label>
            <button type="submit">Save</button>
        </div>
        <div>
            <button type="submit">Save Card to Deck!</button>
            <button type="submit">Discard dis card!</button>
        </div>
      </form>
    </div>
</template>

<script>
export default {
    name: 'Card',
    data(){
        return {
            
        }
    },
    methods: {

    }
}
</script>

<style>

</style>