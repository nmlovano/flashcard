<template>
    <div class="card">
        <h1>Card</h1>
        <div>
            <label for="input-text" class="sr-only">Enter text here!</label>
            <input type="text" id="input-text" class="input-text" placeholder="Enter text here!"/>
        </div>
        <div>
            <label for="fronttext" class="fronttext">Front Text</label>
            <button type="radio"></button>
        </div>
        <div>
            <label for="backtext" class="backtext">Back Text</label>
            <button type="radio"></button>
        </div>
        <div>
            <form action="/Decks">
                <button type="submit">Save Card to Deck!</button>
                <button type="submit">Discard dis card!</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: 'card',
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