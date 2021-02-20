declare module '@capacitor/core' {
    interface PluginRegistry {
        Wallpaper: WallpaperPlugin;
    }
}
export interface WallpaperPlugin {
    echo(options: {
        value: string;
        type: string;
    }): Promise<{
        value: string;
    }>;
}
