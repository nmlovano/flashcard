<template>
    <div class="card">
        <h1>Card</h1>
        <div>
            <p>Sample text, not an error, calm down. :D</p>
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