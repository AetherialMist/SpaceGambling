var path = require('path');

module.exports = {
    entry: path.resolve(__dirname, './src/main/js/app.tsx'),
    mode: 'development',
    devtool: 'cheap-source-map',
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    resolve: {
        extensions: ['*', '.js', '.ts', 'tsx', '.jsx']
    },
    module: {
        rules: [
            {
                test: /\.(t|j)sx?$/,
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-typescript", "@babel/preset-react"]
                    }
                }]
            }
        ]
    }
};