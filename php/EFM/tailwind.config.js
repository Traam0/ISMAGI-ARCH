/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./views/**/*.{html,js,php}",
    "./views/**/*.template.html"
  ],
  theme: {
    extend: {
      colors: {
        primary: "#b28cd9",
        "primary-content": "#33194d",
        "primary-dark": "#9866cc",
        "primary-light": "#ccb2e6",

        secondary: "#b3d98c",
        "secondary-content": "#334d19",
        "secondary-dark": "#9acc66",
        "secondary-light": "#cce6b2",
        background: "#f0eaf5",
        foreground: "#fbfafc",
        border: "#dfd4ea",

        copy: "#261933",
        "copy-light": "#664389",
        "copy-lighter": "#8c65b4",

        success: "#8cd98c",
        warning: "#d9d98c",
        error: "#d98c8c",

        "success-content": "#194d19",
        "warning-content": "#4d4d19",
        "error-content": "#4d1919",

        dark: {
          background: "#191122",
          foreground: "#261933",
          border: "#3f2a56",

          copy: "#fbfafc",
          "copy-light": "#d9cce6",
          "copy-lighter": "#a587c4",

        }
      },
    },
  },
  darkMode: "selector",
  plugins: [],
}

