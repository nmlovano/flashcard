<script>

import AppHeader from './views/AppHeader.vue'
import Home from './views/Home.vue'
import router from './router'
export default {
	name: 'app',
	
	components: {
   
    AppHeader,
    Home
	},
	data() {
		return {
		
		}
	}
}

</script>
 
 <template>
   <div id="app">
        <div id="nav">

 <app-header></app-header>
   
    </div>
   <router-view/>
 </div>
</template>



