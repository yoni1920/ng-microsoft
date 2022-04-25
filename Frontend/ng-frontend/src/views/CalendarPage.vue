<template>
  <v-container class="calendar">
    <Calendar/>
  </v-container>
</template>

<script>
  import Calendar from '../components/Calendar'

  export default {
    name: 'CalendarPage',

    components: {
      Calendar,
    },
  }
</script>
