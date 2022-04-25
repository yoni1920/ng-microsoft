<template>
  <v-row class="fill-height">
    <v-col>
      <v-sheet height="64">
        <v-toolbar flat>
          <v-btn outlined class="mr-4" color="grey darken-2" @click="setToday">
            Today
          </v-btn>
          <v-btn fab text small color="grey darken-2" @click="prev">
            <v-icon small> mdi-chevron-left </v-icon>
          </v-btn>
          <v-btn fab text small color="grey darken-2" @click="next">
            <v-icon small> mdi-chevron-right </v-icon>
          </v-btn>
          <v-toolbar-title v-if="$refs.calendar">
            {{ $refs.calendar.title }}
          </v-toolbar-title>
          <v-spacer></v-spacer>
          <v-menu bottom right>
            <template v-slot:activator="{ on, attrs }">
              <v-btn outlined color="grey darken-2" v-bind="attrs" v-on="on">
                <span>{{ typeToLabel[type] }}</span>
                <v-icon right> mdi-menu-down </v-icon>
              </v-btn>
            </template>
            <v-list>
              <v-list-item @click="type = 'week'">
                <v-list-item-title>Week</v-list-item-title>
              </v-list-item>
              <v-list-item @click="type = 'day'">
                <v-list-item-title>Day</v-list-item-title>
              </v-list-item>
              <v-list-item @click="type = 'month'">
                <v-list-item-title>Month</v-list-item-title>
              </v-list-item>
              <v-list-item @click="type = '4day'">
                <v-list-item-title>4 days</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>
        </v-toolbar>
      </v-sheet>
      <v-sheet height="600">
        <v-calendar
          ref="calendar"
          v-model="focus"
          color="primary"
          :events="events"
          :event-color="getEventColor"
          :type="type"
          first-time="06:00"
          interval-count="18"
          @click:event="showEvent"
          @click:more="viewDay"
          @click:date="viewDay"
          @mousedown:time="setSelectedStartTime"
          @mouseup:time="openZibi"
          @change="updateRange"
        ></v-calendar>
        <v-menu
          v-model="selectedOpen"
          :close-on-content-click="false"
          :activator="selectedElement"
          transition="scale-transition"
        >
          <v-card color="grey lighten-4" min-width="350px" flat>
            <v-toolbar :color="selectedEvent.color" dark>
              <v-btn icon>
                <v-icon>mdi-pencil</v-icon>
              </v-btn>
              <v-toolbar-title v-html="selectedEvent.name"></v-toolbar-title>
              <v-spacer></v-spacer>
              <v-btn icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </v-toolbar>
            <v-card-text class="font-weight-light text-h5">
                <v-list>
                    <v-list-item
                        v-for="(value, field) in operEventData"
                        :key="field"
                    >
                        <v-list-item-title>{{ `${field}: ${value}` }}</v-list-item-title>
                    </v-list-item>
                   
                </v-list>
            </v-card-text>
            <v-card-actions>
              <v-btn text color="secondary" @click="selectedOpen = false">
                Cancel
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-menu>
      </v-sheet>
    </v-col>
    <Form :dialog="this.shouldDisplayForm" @closeModal="setShouldDisplayForm" />
  </v-row>
</template>

<script>
  import activitiesExample from '../data/activitiesExample.json'
  import colorStatus from './StatusMapping.js'
  import Form from "@/components/Form.vue";

  export default {
    components: {
        Form
    },
    data: () => ({
        focus: "",
        type: "week",
        typeToLabel: {
        week: "Week",
        day: "Day",
        "4day": "4 Days",
        month: "Month",
        },
        selectedStartTime: {},
        selectedEndTime: {},
        shouldDisplayForm: false,
        selectedEvent: {},
        selectedElement: null,
        selectedOpen: false,
        events: []
    }),
    mounted () {
      this.$refs.calendar.checkChange()
    },
    methods: {
    viewDay({ date }) {
      this.focus = date;
      this.type = "day";
    },
    getEventColor(event) {
      return event.color;
    },
    setToday() {
      this.focus = "";
    },
    setSelectedStartTime(event) {
      this.selectedStartTime = new Date(`${event.date}T${event.time}`);
    },
    openZibi(event) {
      this.selectedEndTime = new Date(`${event.date}T${event.time}`);
      this.shouldDisplayForm = true;
    },
    setShouldDisplayForm(value) {
      this.shouldDisplayForm = value;
    },
    prev() {
      this.$refs.calendar.prev();
    },
    next() {
      this.$refs.calendar.next();
    },
    showEvent({ nativeEvent, event }) {
      const open = () => {
        this.selectedEvent = event;
        this.selectedElement = nativeEvent.target;
        requestAnimationFrame(() =>
          requestAnimationFrame(() => (this.selectedOpen = true))
        );
      };

      if (this.selectedOpen) {
        this.selectedOpen = false;
        requestAnimationFrame(() => requestAnimationFrame(() => open()));
      } else {
        open();
      }

        nativeEvent.stopPropagation()
      },
      updateRange () {
        const events = []
        activitiesExample.forEach(element => {
        const color = colorStatus.get(element.status) ?? 'grey';

        events.push({
            name: element.name,
            start: new Date(element.startDate),
            end: new Date(element.endDate),
            status: element.status,
            timed: true,
            operationalImpact: element.operationalImpact,
            clientsImpact: element.clientsImpact,
            color,
            steps: element.steps,
            systemId: element.systemId
          })
        });

      console.log(events);

        this.events = events
      }
    },
    computed: {
        operEventData() {
            let startDate = this.selectedEvent.start;

            if (startDate) {
                startDate = startDate.toLocaleDateString('en-us', { hour: "numeric", minute: "numeric", weekday:"short", year:"numeric", month:"short", day:"numeric"})
            }

            let endDate = this.selectedEvent.end;

            if (endDate) {
                endDate = endDate.toLocaleDateString('en-us', { hour: "numeric", minute: "numeric", weekday:"short", year:"numeric", month:"short", day:"numeric"})
            }

            return {
                    'Activity': this.selectedEvent.name,
                    'System': this.selectedEvent.systemId,
                    'Status': this.selectedEvent.status,
                    "Start Time": startDate,
                    'Ending Time': endDate,
                    'Operational Impact': this.selectedEvent.operationalImpact,
                    'Client Impact': this.selectedEvent.clientsImpact
            }
        }
    }
  }
</script>