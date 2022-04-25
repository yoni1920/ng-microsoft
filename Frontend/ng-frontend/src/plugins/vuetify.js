import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';
import colors from "vuetify/lib/util/colors";


Vue.use(Vuetify);

export default new Vuetify({
    themes: {
        light: {
          primary: colors.teal.darken1
        },
      },

});
