const path = require('path');
function resolve(dir){
  return path.join(__dirname,dir)//path.join(__dirname)absolute path

}

module.exports = {
  css: {
    loaderOptions: {
      less: {
        lessOptions: {
          modifyVars: {
            'font-size-base': '16px',
            'font-size-lg': '18px',
            'font-size-sm': '14px'
          },
          javascriptEnabled: true,
        },
      },
    },
  },
  chainWebpack:(config)=>{
    config.resolve.alias
        .set('@',resolve('./src'))
        .set('components',resolve('./src/components'))
        .set('assets',resolve('./src/assets'))
        .set('views',resolve('./src/views'))
  }
};
