import Vue from 'vue'
import Router from 'vue-router'
import auth from './auth'
import Home from './views/Home.vue'
import Login from './views/Login.vue'
import Register from './views/Register.vue'
import Search from './views/Search.vue'
import User from './views/User.vue'
import SearchResults from './views/SearchResults.vue'
import Decks from './views/Decks.vue'
import Card from './views/Card.vue'
import Admin from './views/Admin.vue'
import Contact from './views/Contact.vue'
Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
        path: '/Home',
        name: 'home',
        component: Home,
        meta: {
          requiresAuth: false
        }
      },
      
    {
      path: "/Login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/Register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/Search",
      name: "search",
      component: Search,
      meta: {
        requiresAuth: false
      }
      },
      {
        path: "/User",
        name: "user",
        component: User,
        meta: {
          requiresAuth: false
        }
      },
    {
      path: "/SearchResults",
      name: "searchresults",
      component: SearchResults,
        meta: {
        requiresAuth: false
        }
    },
    {
      path: '/Decks',
      name: 'decks',
      component: Decks,
    
    },
    {
      path: '/Card',
      name: 'card',
      component: Card,
    
    },
    {
      path: '/Login',
      name: 'accountcreated',
      component: Login,
    
    },
    {
      path: '/Contact',
      name: 'contact',
      component: Contact,
    
    },
    {
      path: '/Admin',
      name: 'admin',
      component: Admin,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const user = auth.getUser();

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && !user) {
    next("/Login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
