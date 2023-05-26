const tailwindcss = require('tailwindcss');
module.exports = {
    plugins: [
        tailwindcss('./tailwind.js'),
        require('autoprefixer')
    ],
    content: [
        './src/main/js/**/*.{html,jsx,tsx}'
    ]
};