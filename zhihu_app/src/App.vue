<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>
<template>
  <div>
    <nav>
      <RouterLink to="/">
        专题
      </RouterLink>
      <RouterLink to="/user">
        用户
      </RouterLink>
    </nav>
  </div>
  <RouterView />
</template>
<style>
* {
  margin: 0;
  padding: 0;
}
nav {
  width: 100%;
  font-size: 16px;
  text-align: center;
  padding: 15px 0;
  background-color: #fff;
  border: 1px solid #f6f6f6;
}
nav a {
  display: inline-block;
  padding: 0 1rem;
  text-decoration: none;
  color: #333;
}
nav a.router-link-exact-active {
  color: #3670ee;
  font-weight: bold;
}
</style>
