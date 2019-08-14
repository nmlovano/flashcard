<script>
import AppFooter from './views/AppFooter.vue'
import AppHeader from './views/AppHeader.vue'
import Home from './views/Home.vue'
import router from './router'
export default {
	name: 'app',
	
	components: {
    AppFooter, 
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
 <app-footer></app-footer>
 <app-header></app-header>
   
    </div>
   <router-view/>
 </div>
</template>



