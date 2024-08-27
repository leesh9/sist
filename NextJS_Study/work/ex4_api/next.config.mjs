/** @type {import('next').NextConfig} */
const nextConfig = {
    reactStrictMode: true,
    swcMinify: true,

    async redirects() {
        return [
            {
                source: "/ArpltnInforInqireSvc/:path*",
                destination: "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/:path*",
                permanent : true
            },
        ];
    },
};

export default nextConfig;
