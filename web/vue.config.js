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
};
