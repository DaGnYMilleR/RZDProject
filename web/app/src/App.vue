<template>
  <header class="header">
    <span class="header_name">РЖД Поездки</span>
    <div class="header_nav">
      <router-link to="/">Поездка</router-link>
    </div>
  </header>
  <router-view />
  <div class="footer">
    <div class="contacts">Контакты: Асанов Магаз Оразкимович</div>
  </div>
</template>

<style lang="scss">
#app {
  display: flex;
  flex-direction: column;
  height: 100vh;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  font-size: 1.3vw;
}

.header {
  background: black;

  &_name {
    color: red;
    margin: 0;
  }

  &_nav {
    padding: 15px;

    a {
      font-weight: bold;
      color: #2c3e50;

      &.router-link-exact-active {
        color: #42b983;
      }
    }
  }
}

.footer {
  width: 100%;
}

.contacts {
  padding: 10px;
  background: #39b54a;
}
</style>
