/** @type {import('next').NextConfig} */
const nextConfig = {
    rewrites: async () => {
        return [
            {
                source: '/api/member/:path*',
                destination: 'http://localhost:8080/api/member/:path*'
            }
        ]
    }
};

export default nextConfig;
