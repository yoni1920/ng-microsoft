<template>
  <div class="text-center">
    <v-dialog v-model="dialog" width="800">
      <v-card>
        <v-card-title color="primary" class="text-h5 justify-center">
          נוהל מתח
        </v-card-title>

        <v-form
          ref="form"
          v-model="valid"
          lazy-validation
          @submit.prevent="submit"
        >
          <v-container fluid>
            <v-row justify="center">
              <v-col cols="12" sm="3">
                <v-switch
                  v-model="isTerminating"
                  color="red darken-3"
                  label="פעילות משביתה"
                  required
                ></v-switch>
              </v-col>
            </v-row>

            <v-row justify="center">
              <v-col cols="12" sm="7">
                <v-text-field
                  v-model="name"
                  :rules="nameRules"
                  label="שם הפעילות"
                  required
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row justify="center">
              <v-col cols="12" sm="7">
                <v-text-field
                  v-model="name"
                  :rules="nameRules"
                  label="מטרת הפעילות"
                  required
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row justify="center">
              <v-col cols="12" sm="7">
                <v-textarea
                  auto-grow="true"
                  rows="3"
                  v-model="name"
                  :rules="nameRules"
                  label="השפעה מבצעית"
                  required
                ></v-textarea>
              </v-col>
            </v-row>

            <v-row justify="center">
              <v-col cols="12" sm="7">
                <v-textarea
                  auto-grow="true"
                  rows="3"
                  v-model="name"
                  :rules="nameRules"
                  label="השפעה על לקוחות"
                  required
                ></v-textarea>
              </v-col>
            </v-row>

            <v-row justify="center">
              <v-col cols="12" sm="7">
                <v-file-input
                  show-size
                  counter
                  multiple
                  label="צרפו קבצים / סקריפטים רלוונטים"
                ></v-file-input>
              </v-col>
            </v-row>
          </v-container>
        </v-form>
        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green" text @click="close"> העלו לתיאום </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
export default {
  name: "Form",
  data() {
    return {
      isTerminating: false,
    };
  },
  props: {
    dialog: {
      type: Boolean,
    },
    startDate:{
      type: Date
    },
    endDate: {
      type: Date
    }
  },
  methods: {
    close() {
      this.$emit("closeModal", false);
    },
  },
};
</script>