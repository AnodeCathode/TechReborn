package techreborn.packets;

import io.netty.buffer.ByteBuf;
import reborncore.common.packets.SimplePacket;
import techreborn.tiles.energy.storage.TileAESU;

import java.io.IOException;

public class PacketAesu extends SimplePacket
{

	int buttonID;
	TileAESU aesu;

	public PacketAesu()
	{
	}

	public PacketAesu(int buttonID, TileAESU aesu)
	{
		this.aesu = aesu;
		this.buttonID = buttonID;
	}

	@Override
	public void writeData(ByteBuf out) throws IOException
	{
		SimplePacket.writeTileEntity(aesu, out);
		out.writeInt(buttonID);
	}

	@Override
	public void readData(ByteBuf in) throws IOException
	{
		this.aesu = (TileAESU) SimplePacket.readTileEntity(in);
		buttonID = in.readInt();
	}

	@Override
	public void execute()
	{
		if (!aesu.getWorld().isRemote)
		{
			aesu.handleGuiInputFromClient(buttonID);
		}
	}
}
