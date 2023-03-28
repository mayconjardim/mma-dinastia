/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}"],
  daisyui: {
    themes: [
      {
        mytheme: {
          primary: "#0a0f0d",

          secondary: "#4c027a",

          accent: "#d266e2",

          neutral: "#281E29",

          "base-100": "#F8F6F8",

          info: "#4369D0",

          success: "#166940",

          warning: "#977411",

          error: "#DA2549",
        },
      },
    ],
  },
  plugins: [require("daisyui")],
};
