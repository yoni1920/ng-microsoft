<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <v-layout class="align-center justify-center">
        <div class="text-h3 font-weight-light">WARooM</div>
      </v-layout>
    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
