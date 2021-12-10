import Vue from 'vue';
import colors from "vuetify/es5/util/colors";
import Vuetify from 'vuetify/lib/framework';
import "vuetify/dist/vuetify.min.css";
Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: colors.blue.darken1,
                secondary: colors.red.darken2,
                accent: colors.indigo.base,
            },
        },
    },
});
