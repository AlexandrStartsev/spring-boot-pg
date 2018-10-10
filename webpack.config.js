const WebpackShellPlugin = require('webpack-shell-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const path = require('path');
const webpack = require("webpack");

module.exports = [{
  output: {
    filename: '[name].js',
    chunkFilename: '[name].js',
    path: path.resolve(__dirname, 'src/main/webapp/static/webpack'),
    publicPath: '', 
  },
  optimization: {
    //minimize: false,
    splitChunks: {
      chunks: 'all'
    }
  },         
  entry: {
    loader: './src/main/ts/test.tsx'
  },
  mode: "production",
  plugins: [
    new CleanWebpackPlugin(["src/main/webapp/static/webpack"]), 
    // https://github.com/jantimon/html-webpack-plugin
    new HtmlWebpackPlugin({ filename: "frontend-plugin-test.html", title: "Generated" }),
  ],
  devtool: 'source-map',
  resolve: {
    extensions: [ '.tsx', '.ts', '.js' ],
    modules: [
      "node_modules"
    ]
  },
  module: {
    rules: [
      {
        test: /\.ts$/,
        use: 'ts-loader',
        exclude: /node_modules/
      },
      {
        test: /\.tsx$/,
        use: [
          'ts-loader'
        ],
        exclude: /node_modules/
      },
      {
        test: /\.css$/,
        use: [
          'style-loader',
          'css-loader'
        ]
      },
      {
        test: /\.(png|svg|jpg|gif)$/,
        use: [
          'file-loader'
        ]
      },
      {
        test: /\.(html)$/,
        use: {
          loader: 'html-loader',
          options: {
            attrs: [':data-src']
          }
        }
      } 
    ]
  }  
}];
