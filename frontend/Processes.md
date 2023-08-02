- TailWindCSS
    - https://tailwindcss.com/docs/guides/create-react-app
    - npm install -D tailwindcss
    - npx tailwindcss init
    <br>
    - tailwind.config.js :  
    ```
    /** @type {import('tailwindcss').Config} */
    module.exports = {
    content: [
        ["./src/**/*.{js,jsx,ts,tsx}",]
    ],
    theme: {
        extend: {},
    },
    plugins: [],
    }
    ```
    - index.css :  
    ```
    @tailwind base;
    @tailwind components;
    @tailwind utilities;
    body {
        background-color: #000300;
    }
    ```

- VSCODE Extensions : 
    - Tailwind CSS IntelliSense

- React Icons : 
    - npm install react-icons --save