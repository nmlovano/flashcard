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
import AppHeader from './views/AppHeader.vue'
import AllDecks from './views/AllDecks.vue'
import CardsByDeckShuffled from './views/CardsByDeckShuffled'
import CardsByDeck from './views/CardsByDeck'
import Logout from "./views/Logout"
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
        path: '/',
        name: 'home',
        component: Home,
        meta: {
          
        }
      },
      
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/search",
      name: "search",
      component: Search,
      meta: {
        requiresAuth: false
      }
      },
      {
        path: "/user",
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
      path: '/addDeck',
      name: 'addDeck',
      component: Decks,
    
    },
    {
      path: '/allDecks',
      name: 'allDecks',
      component: AllDecks
    },
    {
      path: '/card',
      name: 'card',
      component: Card,
    
    },
    {
      path: '/contact',
      name: 'contact',
      component: Contact,
    
    },
    {
      path: '/admin',
      name: 'admin',
      component: Admin,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/AppHeader',
      name: 'appHeader',
      component: AppHeader,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/cardsByDeckShuffled',
      name: 'cardsByDeckShuffled',
      component: CardsByDeckShuffled,
    },
    {
      path: '/cardsByDeck/:deckId',
      name: 'cardsByDeck',
      component: CardsByDeck,
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const user = auth.getUser();

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && !user) {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
