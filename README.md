# ElytraGuard
ElytraGuard is a plugin for Minecraft servers that helps manage elytra usage in the game. It provides options for administrators to control how players can use elytra, such as disabling the ability to fly with elytra, disabling elytra use altogether, or removing elytra from a player's inventory after they have used it. The plugin also has permission options to give certain players the ability to fly with elytra or use it without restrictions. ElytraGuard is useful for servers that want to limit elytra usage and add a level of customization to elytra usage on their servers.

```
permissions:
  removeelytra.elytrafly:
    description: This permission allow to player to fly with elytra. This permission work if actived from config
    default: op
  removeelytra.use.elytra:
    description: This permission allow to users to use elytra without forbidden. This permission work if actived from config
    default: op
  removeelytra.autoremoveelytra:
    description: This permission allow to users to use elytra without remove elytra from invsee. This permission work if actived from config
    default: op
```