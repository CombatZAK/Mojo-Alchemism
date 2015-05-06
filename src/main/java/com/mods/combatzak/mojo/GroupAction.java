package com.mods.combatzak.mojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A collection of Action objects that are all invoked together
 * @author CombatZAK
 *
 */
public class GroupAction extends MojoAction implements List<MojoAction> {
	private List<MojoAction> actions = new ArrayList<MojoAction>(); //stores a list of actions to be implemented
	
	@Override
	public boolean add(MojoAction e) {
		return actions.add(e);
	}

	@Override
	public void add(int index, MojoAction element) {
		actions.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends MojoAction> c) {
		return actions.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends MojoAction> c) {
		return actions.addAll(index, c);
	}

	@Override
	public void clear() {
		actions.clear();
	}

	@Override
	public boolean contains(Object o) {
		return actions.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return actions.containsAll(c);
	}

	@Override
	public MojoAction get(int index) {
		return actions.get(index);
	}

	@Override
	public int indexOf(Object o) {
		return actions.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return actions.isEmpty();
	}

	@Override
	public Iterator<MojoAction> iterator() {
		return actions.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return actions.lastIndexOf(o);
	}

	@Override
	public ListIterator<MojoAction> listIterator() {
		return actions.listIterator();
	}

	@Override
	public ListIterator<MojoAction> listIterator(int index) {
		return actions.listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MojoAction remove(int index) {
		return actions.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return actions.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MojoAction set(int index, MojoAction element) {
		return actions.set(index, element);
	}

	@Override
	public int size() {
		return actions.size();
	}

	@Override
	public List<MojoAction> subList(int fromIndex, int toIndex) {
		return actions.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return actions.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return actions.toArray(a);
	}

	/**
	 * Applies all actions contained within this one
	 */
	@Override
	public boolean apply() {
		//go through and apply each of the contained actions
		for (MojoAction action : actions) {
			action.apply();
		}
		
		this.setIsApplied(true); //mark this action applied
		return true;
	}
	
	
}
